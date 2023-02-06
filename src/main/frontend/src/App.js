import React from 'react'
import styled from 'styled-components'
import { useTable } from 'react-table'
import { useState, useEffect } from 'react';

import Data from './Data'

const Styles = styled.div`
  padding: 1rem;

  table {
    border-spacing: 0;
    border: 1px solid black;

    tr {
      :last-child {
        td {
          border-bottom: 0;
        }
      }
    }

    th,
    td {
      margin: 0;
      padding: 0.5rem;
      border-bottom: 1px solid black;
      border-right: 1px solid black;

      :last-child {
        border-right: 0;
      }
    }
  }
`

function Table({ columns, data }) {
  // Use the state and functions returned from useTable to build your UI
  const {
    getTableProps,
    getTableBodyProps,
    headerGroups,
    rows,
    prepareRow,
  } = useTable({
    columns,
    data,
  })

  // Render the UI for your table
  return (
    <table {...getTableProps()}>
      <thead>
        {headerGroups.map(headerGroup => (
          <tr {...headerGroup.getHeaderGroupProps()}>
            {headerGroup.headers.map(column => (
              <th {...column.getHeaderProps()}>{column.render('Header')}</th>
            ))}
          </tr>
        ))}
      </thead>
      <tbody {...getTableBodyProps()}>
        {rows.map((row, i) => {
          prepareRow(row)
          return (
            <tr {...row.getRowProps()}>
              {row.cells.map(cell => {
                return <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
              })}
            </tr>
          )
        })}
      </tbody>
    </table>
  )
}

function App() {
  
  const [posts, setPosts] = useState([]);
  useEffect(() => {
     fetch('http://localhost:8080')
        .then((response) => response.json())
        .then((data) => {
           console.log(data);
           setPosts(data);
        })
        .catch((err) => {
           console.log(err.message);
        });
  }, []);

  const columns = React.useMemo(
    () => [
      {
        Header: 'Name',
        columns: [
          {
            Header: 'Id',
            accessor: 'id',
          },
          {
            Header: 'First Name',
            accessor: 'first',
          },
          {
            Header: 'Last Name',
            accessor: 'last',
          },
        ],
      },
      {
        Header: 'Information',
        columns: [
          {
            Header: 'Email',
            accessor: 'email',
          },
          {
            Header: 'Profession',
            accessor: 'profession',
          },
          {
            Header: 'Country',
            accessor: 'country',
          },
          {
            Header: 'City',
            accessor: 'city',
          },
          {
            Header: 'Date',
            accessor: 'date',
          },
        ],
      },
    ],
    []
  )

  const data = React.useMemo(() => Data(20), [])

  return (
    <Styles>
      <Table columns={columns} data={data} />
    </Styles>
  )
}

export default App

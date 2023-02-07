import React from 'react'
import styled from 'styled-components'
import useState from 'react'
import useEffect from 'react'


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
function App() {
  
  const [, setPosts] = useState([]);
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

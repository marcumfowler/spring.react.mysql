import React from "react";
import { makeStyles } from "@mui/core/styles";
import Table from "@mui/core/Table";
import TableBody from "@mui/core/TableBody";
import TableCell from "@mui/core/TableCell";
import TableContainer from "@mui/core/TableContainer";
import TableHead from "@mui/core/TableHead";
import TableRow from "@mui/core/TableRow";
import Paper from "@mui/core/Paper";
import Avatar from "@mui/core/Avatar";
import GroupIcon from "@mui/icons/Group";
import { Link } from "react-router-dom";
import Typography from "@mui/core/Typography";
import CircularProgress from "@mui/core/CircularProgress";

const useStyles = makeStyles(theme => ({
  table: {
    minWidth: 600
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  paper: {
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    margin: `10px`,
    height: "100%",
    width: "99%",
    marginTop: theme.spacing(7)
  },
  link: {
    color: "rgba(0,0,0,0.65)",
    textDecoration: "none",
    marginLeft: "10%",
    alignSelf: "flex-start",
    "&:hover": {
      color: "rgba(0,0,0,1)"
    }
  }
}));

export default function SimpleTable() {
  const classes = useStyles();

  const [data, upDateData] = React.useState([]);
  const [firstLoad, setLoad] = React.useState(true);
  let isLoading = true;

  async function sampleFunc() {
    let response = await fetch("/api/user");
    let body = await response.json();
    upDateData(body);
  }

  if (firstLoad) {
    sampleFunc();
    setLoad(false);
  }

  if (data.length > 0) isLoading = false;

  return (
    <div className={classes.paper}>
      <Avatar className={classes.avatar}>
        <GroupIcon />
      </Avatar>
      <Typography component="h1" variant="h5">
        Employee Directory
      </Typography>

      {isLoading ? (
        <CircularProgress />
      ) : (
        <TableContainer
          style={{ width: "80%", margin: "0 10px" }}
          component={Paper}
        >
          <Table className={classes.table} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell align="center">Name</TableCell>
                <TableCell align="center">Department</TableCell>
                <TableCell align="center">Gender</TableCell>
                <TableCell align="center">Dob</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {data?.map(row => (
                <TableRow key={row.name}>
                  <TableCell align="center">{row.name}</TableCell>
                  <TableCell align="center">{row.department}</TableCell>
                  <TableCell align="center">{row.gender}</TableCell>
                  <TableCell align="center">{row.dob}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      )}
      <Link className={classes.link} to="/">
        {" "}
        <Typography align="left">
          &#x2190; Head back to save data
        </Typography>{" "}
      </Link>
    </div>
  );
}
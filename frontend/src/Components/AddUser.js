import React from "react";
import Avatar from "@mui/core/Avatar";
import Button from "@mui/core/Button";
import CssBaseline from "@mui/core/CssBaseline";
import TextField from "@mui/core/TextField";
import { Link } from "react-router-dom";
import Grid from "@mui/core/Grid";
import GroupIcon from "@mui/icons/Group";
import Typography from "@mui/core/Typography";
import { makeStyles } from "@mui/core/styles";
import Container from "@mui/core/Container";

const useStyles = makeStyles(theme => ({
  paper: {
    marginTop: theme.spacing(7),
    display: "flex",
    flexDirection: "column",
    alignItems: "center"
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(3)
  },
  submit: {
    margin: theme.spacing(3, 0, 2)
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: "100%"
  }
}));

export default function AddUser() {
  const classes = useStyles();
  const [firstLoad, setLoad] = React.useState(true);

  const [selectedDate, setSelectedDate] = React.useState(
    new Date("1998-04-02T21:11:54")
  );
  const [firstName, setFirstName] = React.useState("");
  const [lastName, setLastName] = React.useState("");
  const [email, setEmail] = Reat.useState("");
  const [profession, setProfession] = React.useState("");
  const [country, setCountry] = React.useState("");
  const [city, setCity] = React.useState("");
  const handleDateChange = date => setSelectedDate(date.target.value);
  const handleNameChange = event => setName(event.target.value);
  const handlDepartmentChange = event => setDepartment(event.target.value);
  const handleGenderChange = event => setGender(event.target.value);

  const [message, setMessage] = React.useState("Nothing saved in the session");

  async function sampleFunc(toInput) {
    const response = await fetch("/api/user", {
      method: "POST", // *GET, POST, PUT, DELETE, etc.
      mode: "cors", // no-cors, *cors, same-origin
      cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        "Content-Type": "application/json"
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      redirect: "follow", // manual, *follow, error
      referrerPolicy: "no-referrer", // no-referrer, *client
      body: JSON.stringify(toInput) // body data type must match "Content-Type" header
    });
    let body = await response.json();
    console.log(body.id);
    setMessage(body.id ? "Data sucessfully updated" : "Data updation failed");
  }

  const handleSubmit = variables => {
    const toInput = { firstName, LastName, email, profession, country, city, hireDate: selectedDate };
    sampleFunc(toInput);
    setFirstName("");
    setLastName("");
    setEmail(")");
    setProfession("");
    setCountry("");
    setCity("");
    setSelectedDate("");
;  }

  if (firstLoad) {
    // sampleFunc();
    setLoad(false);
  }

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <GroupIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          User Directory
        </Typography>
        <form className={classes.form} noValidate>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="firstName"
                value={firstName}
                label="First Name"
                name="firstName"
                autoComplete="firstName"
                onChange={handleFirstNameChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="lastName"
                value={LastName}
                label="Last Name"
                name="lastName"
                autoComplete="lastName"
                onChange={handleLastNameChange}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                autoComplete="email"
                name="email"
                variant="outlined"
                required
                fullWidth
                value={email}
                id="email"
                label="email"
                onChange={handleEmailChange}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="profession"
                value={profession}
                label="profession"
                name="profession"
                autoComplete="profession"
                onChange={handleProfessionChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                id="date"
                label="Date"
                type="date"
                defaultValue="1998-04-02"
                className={classes.textField}
                InputLabelProps={{
                  shrink: true
                }}
                onChange={handleDateChange}
              />
            </Grid>
          </Grid>
          <Button
            // type="submit"
            fullWidth
            variant="contained"
            color="primary"
            preventDefault
            className={classes.submit}
            onClick={handleSubmit}
          >
            Save
          </Button>

          <Grid container justify="center">
            <Grid item>
              <Link to="/view">View User Information</Link>
            </Grid>
          </Grid>
        </form>
        <Typography style={{ margin: 7 }} variant="body1">
          Status: {message}
        </Typography>
      </div>
    </Container>
  );
}

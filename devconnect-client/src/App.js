import React,{Component} from 'react'
import './App.css';
import Dashboard from './components/Dashboard';
import NavBar from './components/Layout/NavBar';
import {BrowserRouter as Router,Route} from "react-router-dom"
import AddProject from './components/Project/AddProject';


class App extends Component {
  render(){
    return (
    
    <Router>
      <div className="App">
      <NavBar/>
      <Route exact path="/dashboard" component={Dashboard} />
      <Route exact path="/addProject" component={AddProject} />
    </div>
    </Router>
     
    );
  }
  
    
    
 
}

export default App;

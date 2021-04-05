import axios from 'axios'
import {GET_ERRORS} from '../actions/types'

const url = "http://localhost:8080/api/projects"

export const createProject = (project,history)=>async dispatch=>{
try {
  const res= await axios.post(url,project)
  history.push("/dashboard")
} catch (error) {
  dispatch({type: GET_ERRORS, payload: error.response.data})
}
}
import axios from 'axios';
import { useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
function MovieDisplay(){
    const[movie,setMovie]=useState([]);

    useEffect(()=>{
        showMovie();
      },[])
//First getting all the daqta from the database then storing it in result after than setting the whole value into movie and using the movie I am mapping all data dynamically into the table
    async function showMovie(){
        const result=await axios.get("http://localhost:8085/get/movie");
        setMovie(result.data);
    }

    const deleteMovie=async(id)=>{
        await axios.get(`http://localhost:8085/deleteMovie/${id}`);
        showMovie();
    }
        

    return(
        <div>
            <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>Sl.No</th>
          <th>MovieId</th>
          <th>MovieName</th>
          <th>Language</th>
          <th>Duration</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>

          {movie.map((mov,index)=>(
            <tr>

            <td>{index+1}</td>
            <td>{mov.MovieId}</td>
          <td>{mov.MovieName}</td>
          <td>{mov.Language}</td>
          <td>{mov.Duration}</td>
          <td>
          <Link variant="info" className="btn btn-sm btn-info" to={`/MovieEdit/${mov.MovieId}`}>Edit</Link>{'  '}
          
          <Link variant="secondary" className="btn btn-sm btn-secondary" onClick={(e)=>deleteMovie(mov.MovieId)} >Delete</Link>
          </td>
        </tr>
          ))
        }
      </tbody>
    </Table>
        </div>
    );
}
export default MovieDisplay;
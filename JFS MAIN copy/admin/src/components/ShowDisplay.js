import axios from 'axios';
import { useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import '../Css/Show.css';
function ShowDisplay(){
    const[show,setshow]=useState([]);

    useEffect(()=>{
        getShow();
      },[])
//First getting all the daqta from the database then storing it in result after than setting the whole value into movie and using the movie I am mapping all data dynamically into the table
    async function getShow(){
        const result=await axios.get("http://localhost:8085/get/show");
        setshow(result.data);
    }

    const deleteShow=async(id)=>{
        await axios.get(`http://localhost:8085/deleteshow/${id}`);
        getShow();
    }
        

    return(
        <div className='Show-Display'>
        <div >
            <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>id</th>
          <th>TheaterId</th>
          <th>MovieId</th>
          <th>Time</th>
          <th>Price</th>
          <th>Available</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>

          {show.map((shows,index)=>(
            <tr>

            <td>{index+1}</td>
          <td>{shows.TId}</td>
          <td>{shows.MId}</td>
          <td>{shows.STime}</td>
          <td>{shows.SPrice}</td>
          <td>{shows.RegularSeatAvailable}</td>
          <td>
          <Link variant="info" className="btn btn-sm btn-info" to={`/ShowEdit/${shows.ShowId}`}>Edit</Link>{'  '}
          
          <Link variant="secondary" className="btn btn-sm btn-secondary" onClick={(e)=>deleteShow(shows.ShowId)} >Delete</Link>
          </td>
        </tr>
          ))
        }
      </tbody>
    </Table>
        </div>
        </div>
    );
}
export default ShowDisplay;
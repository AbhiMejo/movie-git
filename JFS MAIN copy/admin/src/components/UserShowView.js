import axios from 'axios';
import { useEffect, useState } from 'react';
import Table from 'react-bootstrap/Table';
import ListGroup from 'react-bootstrap/ListGroup';
import { useParams } from 'react-router-dom';
function UserShowView(){
    const[MovieShow,setMovieShow]=useState([]);
    const {id}=useParams();

    useEffect(()=>{
        getAsMovie();
    },[])

    const getAsMovie=async()=>{
        const Result=await axios.get(`http://localhost:8085/get/showdetails/${id}`);
        setMovieShow(Result.data);
        console.log("hi",Result)
    }
    return(
                <div>
                    <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>id</th>
          <th>ShowId</th>
          <th>MId</th>
          <th>TId</th>
          <th>ShowTime</th>
          <th>Ticket Price</th>
          <th>Seat Available</th>
        </tr>
      </thead>
      <tbody>

          {MovieShow.map((mov,index)=>(
            <tr>

            <td>{index+1}</td>
          <td>{mov.ShowId}</td>
          <td>{mov.MId}</td>
          <td>{mov.TId}</td>
          <td>{mov.STime}</td>
          <td>{mov.SPrice}</td>
          <td>{mov.RegularSeatAvailable}</td>
          <td>
          </td>
        </tr>
          ))
        }
      </tbody>
    </Table>
                </div>  
            
    
    );
}
export default UserShowView;
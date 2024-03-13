import axios from 'axios';
import { useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import { Link, useParams } from 'react-router-dom';
function TheaterDisplay(){
  const [theaters,settheaters]=useState([]);
//useeffect is used adter render
  useEffect(()=>{
    showDetails();
  },[]);

//
  const deleteTheater=async (id)=>{
    await axios.get(`http://localhost:8085/delete/${id}`);
    showDetails();
  }

  const showDetails = async () =>{
//result is for storeing all the data feom database
    const result=await axios.get("http://localhost:8085/TheaterList");
      settheaters(result.data);
    }
  
    return(
        <div>
            <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>Sl.No</th>
          <th>Id</th>
          <th>TheaterName</th>
          <th>MetroLocation</th>
          <th>District</th>
          <th>NumberOfShows</th>
          <th>SeatingCapacity</th>
          <th>RegervationCapacityRegular</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>

          {theaters.map((theater,index)=>(
            <tr>
              <th scope='row' key={index}>{index+1}</th>
              <th>{theater.TheaterId}</th>
            <td>{theater.TheatreName}</td>
          <td>{theater.MetroLocation}</td>
          <td>{theater.District}</td>
          <td>{theater.NumberOfShows}</td>
          <td>{theater.SeatingCapacity}</td>
          <td>{theater.RegervationCapacityRegular}</td>
          <td>
          <Link variant="info" className="btn btn-sm btn-info" to={`/EditTheater/${theater.TheaterId}`}>Edit</Link>
          <Link variant="secondary" className="btn btn-sm btn-secondary" onClick={()=>deleteTheater(theater.TheaterId)}>Delete</Link>
          </td>
        </tr>
          ))
        }
      </tbody>
    </Table>
        </div>
    );
}
export default TheaterDisplay;
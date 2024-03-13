
import axios from 'axios';
import { useEffect, useState } from 'react';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import InputGroup from 'react-bootstrap/InputGroup';
import { Button } from 'react-bootstrap';
import { useNavigate, useParams } from 'react-router-dom';
function EditTheater(){
    const [TheatreName,setTheatreName]=useState("");
    const [MetroLocation,setMetroLocation]=useState("");
    const [District,setDistrict]=useState("");
    const [NumberOfShows,setNumberOfShows]=useState("");
    const [SeatingCapacity,setSeatingCapacity]=useState("");
    const [RegervationCapacityRegular,setRegervationCapacityRegular]=useState("");
    const {id}=useParams();
    const navigate=useNavigate();
  async function handleSubmit(e){
   
    e.preventDefault();
    try{
        await axios.post(`http://localhost:8085/update/${id}`,{
          TheatreName:TheatreName,
            MetroLocation:MetroLocation,
            District:District,
            NumberOfShows:NumberOfShows,
            SeatingCapacity:SeatingCapacity,
            RegervationCapacityRegular:RegervationCapacityRegular
        });
        alert("Theater details Added Successfully")
        setTheatreName("");
        setMetroLocation("");
        setDistrict("");
        setNumberOfShows("");
        setSeatingCapacity("");
        setRegervationCapacityRegular("")
        navigate("/AdminDash")
    }catch(err){
        alert("Enter Properly")
    }
  };
    return(
        <div>
            <Form onSubmit={handleSubmit}>
      <Row>
        <Col>
          <Form.Control type="text" placeholder="Enter TheaterName" onChange={(e)=>{setTheatreName(e.target.value)}} />
        </Col>
        <Col>
          <Form.Control type="text"placeholder="Enter MetroLocation" onChange={(e)=>{setMetroLocation(e.target.value)}}/>
          <Col>
          <Form.Control type="text" placeholder="District" onChange={(e)=>{setDistrict(e.target.value)}}/>
        </Col>
        </Col>
      </Row>
      <Row>
        <Col>
          <Form.Control type="number" placeholder="NumberOfShows" onChange={(e)=>{setNumberOfShows(e.target.value)}}/>
        </Col>
        <Col>
          <Form.Control type="number" placeholder="SeatingCapacity" onChange={(e)=>{setSeatingCapacity(e.target.value)}}/>
          <Col>
          <Form.Control type="number" placeholder="Enter the RegervationCapacityRegular" onChange={(e)=>{setRegervationCapacityRegular(e.target.value)}}/>
        </Col>
        </Col>
      </Row>
    
      <Button type="submit">Submit form</Button>
      </Form>
        </div>
    );
}
export default EditTheater;
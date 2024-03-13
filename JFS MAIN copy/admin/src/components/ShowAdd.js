import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import InputGroup from 'react-bootstrap/InputGroup';
import { Button } from 'react-bootstrap';
import { useState } from 'react';
import axios from 'axios';
function ShowAdd(){
    const[TId,setTId]=useState("");
    const[MId,setMId]=useState("");
    const[STime,setSTime]=useState("");
    const[SPrice,setSPrice]=useState("");
    const[RegularSeatAvailable,setRegularSeatAvailable]=useState("");

    async function handleSubmit(e){
      e.preventDefault();
      try{
        await axios.post("http://localhost:8085/saveshow",{
          TId : TId,
          MId : MId,
          STime : STime,
          SPrice : SPrice,
          RegularSeatAvailable : RegularSeatAvailable 
        });
        alert("Show Successfully Added")
        setTId("")
        setMId("")
        setSTime("")
        setSPrice("")
        setRegularSeatAvailable("")
      }catch(err){
        alert("Try Again")
      }
    }

  return(
    <div>
      <Form onSubmit={handleSubmit}>
      <Row>
        <Col>
          <Form.Control type="number" placeholder="Enter theaterId" onChange={(e)=>{setTId(e.target.value)}} />
        </Col>
        <Col>
          <Form.Control type="number"placeholder="Enter MovieId" onChange={(e)=>{setMId(e.target.value)}}/>
        </Col>
        <Col>
          <Form.Control type="text"placeholder="Enter Time" onChange={(e)=>{setSTime(e.target.value)}}/>
        </Col>
      </Row>
      <Row>
      <Col>
          <Form.Control type="number"placeholder="Enter Ticket price" onChange={(e)=>{setSPrice(e.target.value)}}/>
        </Col>
        <Col>
          <Form.Control type="number"placeholder="Enter ReserveAvailable" onChange={(e)=>{setRegularSeatAvailable(e.target.value)}}/>
        </Col>
      </Row>
      
      <Button type="submit">Submit form</Button>
      </Form>
    </div>
  );

}
export default ShowAdd;
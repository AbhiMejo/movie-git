import axios from 'axios';
import { useState } from 'react';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import InputGroup from 'react-bootstrap/InputGroup';
import { Button } from 'react-bootstrap';
import { useNavigate, useParams } from 'react-router-dom';


function MovieEdit(){
    const[MovieName, setMovieName]=useState("");
    const[Language,setLanguage]=useState("");
    const[Duration,setDuration]=useState("");
    const navigate=useNavigate();
    const {id}=useParams();

    async function handleSubmit(e){
        e.preventDefault();
        try{
            await axios.post(`http://localhost:8085/upadateMovie/${id}`,{
            MovieName:MovieName,
            Language:Language,
            Duration:Duration
            });
            alert("Adding Movie Successfully");
            setMovieName("");
            setLanguage("");
            setDuration("");
            navigate("/AdminDash");
        }catch(err){
            alert("Enter properly");
        }
    }

    return(
        <Form onSubmit={handleSubmit}>
      <Row>
        <Col>
          <Form.Control type="text" placeholder="Enter Movie" onChange={(e)=>{setMovieName(e.target.value)}} />
        </Col>
        <Col>
          <Form.Control type="text"placeholder="Enter Language" onChange={(e)=>{setLanguage(e.target.value)}}/>
        </Col>
        <Col>
          <Form.Control type="number"placeholder="Enter Duration" onChange={(e)=>{setDuration(e.target.value)}}/>
        </Col>
      </Row>
      
      <Button type="submit">Submit form</Button>
      </Form>
    );
}
export default MovieEdit;
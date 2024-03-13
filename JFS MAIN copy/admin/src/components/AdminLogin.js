import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
function AdminLogin(){
    const[username, setusername]=useState("");
    const[password,setpassword]=useState("");
    const navigate=useNavigate();
    const[isTrue ,setisTrue]=useState(false)
    
    async function handleSubmit(){
        setisTrue(true);
        if(username==="Abhishek" && password==="6296048440"){
            alert("LoginSuccessful")
            navigate('/AdminDash')
        }else{
            alert("Give correct Credientials")
        }
        
    }
    return(
   
    <div style={{marginTop:'8%',marginLeft:'20%',marginRight:'20%'}}>
    <h1>Admin Login</h1>
      <Form onSubmit={handleSubmit} >
    <Form.Group className="mb-3" controlId="formBasicEmail">
    
    <Form.Control name="username" type="text" placeholder="Enter Your UserName" onChange={(e )=> {setusername(e.target.value)}} />
    <Form.Text className="text-muted">
    We'll never share your email with anyone else.
    </Form.Text>
    </Form.Group>
    
    <Form.Group className="mb-3" controlId="formBasicPassword">
    
    <Form.Control name="password" type="password" placeholder="Enter Your Password" onChange={(e )=> {setpassword(e.target.value)}}/>
    </Form.Group>
    <Form.Group className="mb-3" controlId="formBasicCheckbox">
    <Form.Check type="checkbox" label="Check me out" />
    </Form.Group>
    <Button variant="primary" type="submit">
    Submit
    </Button>
    </Form>
    </div>
    );
}
export default AdminLogin;

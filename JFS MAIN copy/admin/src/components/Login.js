import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
function Login(){

    const[userid, setuserid]=useState("");
    const[password,setpassword]=useState("");
    const navigate=useNavigate();
    
    const [status,setstatus]=useState();
    
    async function handleSubmit(e){
        e.preventDefault();
        try{
             const response=await axios.post("http://localhost:8085/userlogin",{
           
            firstname: userid,
            password : password
            
          
            });
            setuserid("")
            setpassword("")
            //this is for checking the data matches with backend return success or not
            if(response.data==="success"){
             alert("Logging Successful ")
             console.log(response.data);
            navigate("/Reservation")
            
              
            }else{
              console.log(response.data);
              alert("Try again");
            }

            

          }catch(err){
            console.log(err);
            alert("please reenter")
        }
        
    }
    return(
        <div style={{marginTop:'8%',marginLeft:'20%',marginRight:'20%'}}>
          <h1>User Login</h1>
            <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        
        <Form.Control name="userid" type="text" placeholder="Enter Your UserName" onChange={(e)=>{setuserid(e.target.value)}} />
        <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
       
        <Form.Control name="password" type="text" placeholder="Password" onChange={(e)=>{setpassword(e.target.value)}}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formBasicCheckbox">
        <Form.Check type="checkbox" label="Check me out" />
      </Form.Group>
      <Button variant="primary" type="submit" onClick={()=>{setstatus(true)}}>
        Submit
      </Button>

      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <Button variant="primary" href='/AdminLogin'>
        Admin
      </Button>
    </Form>
        </div>
    );
}
export default Login;
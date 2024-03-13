import { useState } from "react";
import axios from "axios";
import { redirect, useNavigate } from "react-router-dom";

//import './Style.css';

function Registration(){
    //const data= {fname: "", lname: "", cname: "",sname:"", phone:""}
    //const [id, setid]=useState("");
    const [firstName, setfirstName]=useState("");
    const [lastName, setlastName]=useState("");
    const [password, setpassword]=useState("");
    const [age, setage]=useState("");
    const [gender, setgender]=useState("");
    const [adress, setadress]=useState("");
    const [phoneNumber, setphoneNumber]=useState("");
    const [error, setError]=useState(false);
    const navigate=useNavigate();

    
    // const handleChange=(e)=>{
    //     ;
    //     setfname(e.target.value.firstname);
    //     setlname(e.target.value.lastname);
    //     setcname(e.target.value.cityname);
    //     setsname(e.target.value.statename);
    //     setphone(e.target.value.phone);
    // }
    async function handleSubmit(e){
        e.preventDefault();
       
        try{
            if(firstName==="" || lastName==="" || password==="" || age==="" ||gender==="" ||adress==="" || phoneNumber.length<=9){
                setError(true);
            }
            else{
                
           await axios.post("http://localhost:8085/save",
           {
            firstname : firstName,
            lastname : lastName,
            password : password,
            age : age,
            gender : gender,
            adress :adress,
            phoneNumber : phoneNumber

           });
           alert("User registration successful")
           setfirstName("");
           setlastName("");
           setpassword("");
           setage("");
           setgender("");
           setadress("");
           setphoneNumber("");
           navigate('/Login')

        }}catch(err){
            alert("User Registration failed")
        }
         
    }
    // const goLogin=()=>{
        
    //     navigate('/Login')
    // }
    return(
        <div className="main-form">
            <form  className="reg-Form" onSubmit={handleSubmit}>
                <h1>Registration Form</h1>
                {/* <input type="text" name="id"  onChange={(e )=> {setid(e.target.value)}}/><br/> */}
                <input type="text" name="firstName"  placeholder=" Enter Your First Name"onChange={(e )=> {setfirstName(e.target.value)}}/><br/>
                    <label>{error&&firstName===""?"Fill the First name":""}<br/></label>   
                    <input type="text" name="lastName"  placeholder=" Enter Your Last Name"onChange={(e )=> {setlastName(e.target.value)}}/><br/>
                    <label>{error&&lastName===""?"Fill the Last name":""}<br/></label> 
                    <input type="text" name="password"  placeholder=" Enter Your Password"onChange={(e )=> {setpassword(e.target.value)}}/><br/>
                    <label>{error&&password===""?"Enter your Password":""}<br/></label> 
                    <input type="text" name="age"  placeholder=" Enter Your Age"onChange={(e )=> {setage(e.target.value)}}/><br/>
                    <label>{error&&age===""?"Fill the age":""}<br/></label>  
                    <select name="gender" id="cars" onChange={(e)=>{setgender(e.target.value)}}>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="others">Others</option>
                    </select>
                    <input type="text" name="adress"  placeholder=" Enter Your Adress"onChange={(e )=> {setadress(e.target.value)}}/><br/>
                    <label>{error&&adress===""?"Fill the Adress":""}<br/></label>  
                    <input type="text" name="phoneNumber"  placeholder=" Enter Your Adress"onChange={(e )=> {setphoneNumber(e.target.value)}}/><br/>
                    <label>{error&&phoneNumber===""?"Fill the PhoneNumbern":""}<br/></label>   
                            
                          
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}
export default Registration;
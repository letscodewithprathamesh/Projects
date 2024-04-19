import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { clearError, setError, setLoading } from '../Redux/store';
import { signInWithEmailAndPassword } from "firebase/auth";
import { auth } from '../firebase';
import {useNavigate} from 'react-router-dom'
import { Link } from 'react-router-dom';

export default function Login() 
{

    const [email,setEmail]=useState("");
    const [password,setPassword]=useState("")

    const dispatch =useDispatch()
    const navigate= useNavigate()
    const error=useSelector((state)=>state.product.error)

    async function handleLogin()
    {
       
        dispatch(clearError())

        try
        {
            signInWithEmailAndPassword(auth,email,password).
            then((val)=>{console.log("successfull"+val);  navigate('/dashboard');})
           

            dispatch(setLoading(false))
        }
        catch(error)
        {
            dispatch(setError(error))
        }
    }



  return (
    <div>

        <input type="email" name="" id="email" placeholder="Enter the Email" className='w-full bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out' onChange={(e)=>{setEmail(e.target.value)}} />

        <br />
        <input type="password" name="" id="password" placeholder="Enter the Password"className='w-full bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out' onChange={(e)=>{setPassword(e.target.value)}} />
        <br />

        <button onClick={handleLogin}>LOGIN</button> 
        <br />
        <h2>Not Registered <Link to="/signup"><span>Signup</span></Link> </h2> 
       

        {error && <p>{error}</p>}

    </div>
  )
}

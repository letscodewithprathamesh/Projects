import React, { useRef } from 'react'

export default function Contact()
 {

    const usernameRef=useRef("");
    const emailRef=useRef("");
    const messageRef=useRef("");

    const handlesubmit=(e)=>{
        e.preventDefault(); {/* It stop predefined submission and follow the logic inside the function . if we dont write this method nothing will happen the form will be submitted it wont print on console which written in below lines ,so do that we need to use preventDefault() */}
        console.log(usernameRef.current.value,emailRef.current.value,messageRef.current.value);
        {/*  console.log(usernameRef.current,emailRef.current,messageRef.current);  both are different it will return the object of the element where u had given reference but we want value therefore we need to give value*/}
    }



  return (
    <div className='container p-5 '>
        <form action="" className="form " onSubmit={handlesubmit}>

        <div className='form-floating'>
            
            <input type="text" className="form-control" placeholder='Enter your Name' id='un' ref={usernameRef}/>
            <label htmlFor="" className="form-label">Enter your Name</label>

        </div>

         <br />

        <div className='form-floating'>
            <input type="email" name="" id="em" className="form-control" placeholder='Enter your Email' ref={emailRef}  />
            <label htmlFor="" className="form-label">Enter your Email</label>
        </div>
            
        <br />

        <div className='form-floating'>
            
        <textarea name="" id="ta" cols="30" rows="10" className='form-control' placeholder='Enter the Message' ref={messageRef}></textarea>
         <label htmlFor="" className="form-label">Enter your Message</label>

        </div>

            <br />

            <button className="btn btn-primary">CONTACT</button>
        </form>
    </div>
  )
}

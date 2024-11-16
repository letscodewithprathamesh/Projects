import React from 'react'
import logo from '../assets/react.svg'
import { Link } from 'react-router-dom'

export default function Header()
 {
  return (
    <div className='container-fluid d-flex justify-content-between bg-black text-white'>
        <img src={logo} alt="logo"  className='img-fluid'/>
        <div>
            <ul className='d-flex justify-content-between list-unstyled gap-3'>
                <li><Link to='/'>HOME</Link></li>
                <li><Link to='/about'>ABOUT</Link></li>
                <li><Link to='/contact'>CONTACT</Link></li>
            </ul>
        </div>
    </div>
  )
}

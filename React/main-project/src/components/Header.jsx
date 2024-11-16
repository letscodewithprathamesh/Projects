import React from 'react'
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'

export default function Header() 
{

  const cart=useSelector((state)=>state.product.cart)

  return (
    <header className="text-gray-600 body-font">
  <div className="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
    <a className="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0">
      <span className="ml-3 text-xl">E-COMMERCE</span>
    </a>
    <nav className="md:ml-auto flex flex-wrap items-center text-base justify-center">
      <Link  className="mr-5 hover:text-gray-900"to='/'>HOME</Link>
      <Link  className="mr-5 hover:text-gray-900"to='/about'>ABOUT</Link>
      <Link  className="mr-5 hover:text-gray-900"to='/Products'>PRODUCT</Link>
      <Link  className="mr-5 hover:text-gray-900"to='/contact'>CONTACT</Link>
      
    </nav>
    <Link to='/cart'>
    <button className='inline-flex items-center bg-gray-100 border-0 px-3 focus:outline-none hover:bg-gray-200 rounded text-base md:mt-0'>
      Cart 
      <span className='rounded-lg p-6'>{cart.length}</span>
    </button>
    
    </Link>
   
   <Link to='/login'>
   <button className="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0" >Login
    </button>
   </Link>
    
    </div>
  
</header>
  )
}

import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { removeCart } from '../Redux/store'

export default function Cart() 
{
  const cart=useSelector((state)=>state.product.cart)
  const dispatch=useDispatch()
  return (
    <div>
      <h1>CART</h1>
        <ul>
        {cart && cart.map((cr,i)=>(
        <li key={i}>{cr.title} <button class="inline-flex items-center bg-red-600 border-0 py-1 px-3 focus:outline-none hover:bg-red-800 rounded text-base mt-4 md:mt-0"  onClick={()=>{dispatch(removeCart(cr))}}>Delete</button></li> 
      ))}
        </ul>

        <h1>TOTAL : {cart.reduce((acc,pr)=>acc+pr.price,0)}</h1>  {/*{cart.reduce((acc,pr)=>acc+pr.price,0)} this is reduce() from array metheod applyed on cart array */}

        <button className="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0">
          CHECKOUT
    </button>
    </div>
  )
}

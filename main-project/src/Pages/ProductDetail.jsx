import React from 'react'
import { useParams } from 'react-router-dom'
import { useDispatch} from 'react-redux'
import { useState,useEffect } from 'react'
import { addCart } from '../Redux/store'


export default function ProductDetail() 
{

  const {id}=useParams()
  const dispatch=useDispatch()
  const[productdt,setProductDt]=useState("")

  useEffect(()=>{

    console.log(id);
    fetch(`https://dummyjson.com/products/${id}`).
    then((res)=>res.json()).
    then((data)=>setProductDt(data))
  },[])

  return (
    <div>
      <h1>Product Details</h1>
      <p>Product ID : {id}</p>

      {productdt && (
				<div>
					<section className="text-gray-600 body-font overflow-hidden">
  <div className="container px-5 py-24 mx-auto">
    <div className="lg:w-4/5 mx-auto flex flex-wrap">
      <img alt="ecommerce" className="lg:w-1/2 w-full lg:h-auto h-64 object-cover object-center rounded" src={productdt.thumbnail} />
      <div className="lg:w-1/2 w-full lg:pl-10 lg:py-6 mt-6 lg:mt-0">
									<h2 className="text-sm title-font text-gray-500 tracking-widest">{productdt.category}</h2>
        <h1 className="text-gray-900 text-3xl title-font font-medium mb-1">{productdt.title}</h1>
        <div className="flex mb-4">
          <span className="flex items-center">
           
           
            <span className="text-gray-600 ml-3">4 Reviews</span>
          </span>
          <span className="flex ml-3 pl-3 py-2 border-l-2 border-gray-200 space-x-2s">
            <a className="text-gray-500">
             
            </a>
            <a className="text-gray-500">
             
            </a>
            <a className="text-gray-500">
            
        
            </a>
          </span>
        </div>
									<p className="leading-relaxed">{productdt.description}</p>
        <div className="flex mt-6 items-center pb-5 border-b-2 border-gray-100 mb-5">
          <div className="flex">
            <span className="mr-3">Color</span>
            <button className="border-2 border-gray-300 rounded-full w-6 h-6 focus:outline-none"></button>
            <button className="border-2 border-gray-300 ml-1 bg-gray-700 rounded-full w-6 h-6 focus:outline-none"></button>
            <button className="border-2 border-gray-300 ml-1 bg-red-500 rounded-full w-6 h-6 focus:outline-none"></button>
          </div>
          <div className="flex ml-6 items-center">
            <span className="mr-3">Size</span>
            <div className="relative">
              <select className="rounded border appearance-none border-gray-300 py-2 focus:outline-none focus:ring-2 focus:ring-red-200 focus:border-red-500 text-base pl-3 pr-10">
                <option>SM</option>
                <option>M</option>
                <option>L</option>
                <option>XL</option>
              </select>
              <span className="absolute right-0 top-0 h-full w-10 text-center text-gray-600 pointer-events-none flex items-center justify-center">
            
           
              </span>
            </div>
          </div>
        </div>
        <div className="flex">
          <span className="title-font font-medium text-2xl text-gray-900">{productdt.price}</span>
          <button className="flex ml-auto text-white bg-yellow-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded" onClick={()=>dispatch(addCart(productdt))}>Add to cart</button>
         
          
        </div>
      </div>
    </div>
  </div>
</section>
				</div>
			)}
    </div>
  )
}

import React from 'react'
import { useDispatch,useSelector } from 'react-redux'
import {addCart, setProducts} from '../Redux/store.js'
import { useEffect } from 'react'
import { Link } from 'react-router-dom';

export default function ProductList() 
{

  const dispatch=useDispatch();

  const products=useSelector((state)=>state.product.products)

  useEffect(()=>{
    fetch("https://dummyjson.com/products").
    then((res)=>res.json()).
    then((data)=>{console.log(data.products); dispatch(setProducts(data.products))} )
  },[dispatch])


  return (
    <div>
      <h1>Products</h1>
      <section className="text-gray-600 body-font">
        <div className="container px-5 py-24 mx-auto">
          <div className="flex flex-wrap -m-4">
      {products && products.map((pr,i)=>(

            <div className="p-4 md:w-1/3" key={i}>
              <div className="h-full border-2 border-gray-200 border-opacity-60 rounded-lg overflow-hidden">
                <img className="lg:h-48 md:h-36 w-full object-cover object-center" src={pr.thumbnail} alt={pr.title} />
                <div className="p-6">
                  <h2 className="tracking-widest text-xs title-font font-medium text-gray-400 mb-1">{pr.category}</h2>
                  <Link to={`/product/${pr.id}`}><h1 className="title-font text-lg font-medium text-gray-900 mb-3 hover:text-blue-700">{pr.title}</h1></Link>
                  <p className="leading-relaxed mb-3">{pr.description}</p>
                  <div className="flex items-center flex-wrap ">
                    <a className="text-yellow-500 inline-flex items-center md:mb-2 lg:mb-0"> 
                      <button onClick={()=>dispatch(addCart(pr))} >AddTo Cart</button>
                    </a>
                  </div>
                </div>
              </div>
            </div>
        

      ))}

      </div>
        </div>
        </section> 

      

    </div>
  )
}

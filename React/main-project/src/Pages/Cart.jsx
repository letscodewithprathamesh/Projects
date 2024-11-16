import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { removeCart } from '../Redux/store';

export default function Cart() {
  const cart = useSelector((state) => state.product.cart);
  const dispatch = useDispatch();
  
  return (
    <div className="cart-container h-screen w-screen flex items-center justify-center">
      <div className='bg-yellow-400 h-5/6 w-3/6 mt-3 pt-4 rounded-3xl'>
        <h1 className='flex justify-center font-bold text-5xl text-cyan-950'>CART</h1>
        {cart && cart.length > 0 && (
          <div className='bg-white h-3/5 w-4/5 flex flex-col items-center justify-center mt-5 ml-12'>
            <ul className='font-medium text-2xl text-violet-900'>
              {cart.map((cr, i) => (
                <li key={i}>{cr.title} <button className="inline-flex items-center text-white bg-red-600 border-0 py-1 px-3 focus:outline-none hover:bg-red-800 rounded text-base mt-4 md:mt-0" onClick={() => { dispatch(removeCart(cr)) }}>Delete</button></li>
              ))}
            </ul>
          </div>
        )}
        
        <h1 className='ml-20 mt-5 font-bold text-2xl'>TOTAL : {cart.reduce((acc, pr) => acc + pr.price, 0)}</h1>
        
        <button style={{ marginTop: '2.5rem' }} className="ml-20 bg-blue-500 text-white font-semibold border-0 py-1 px-3 focus:outline-none hover:bg-blue-800 rounded text-base md:mt-0">
          CHECKOUT
        </button>
      </div>
    </div>
  );
}

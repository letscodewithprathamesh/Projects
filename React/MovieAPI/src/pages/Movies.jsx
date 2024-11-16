import axios from 'axios';
import React, { useEffect, useState } from 'react';
import {useNavigate} from 'react-router-dom'

export default function Movies({value}) 
{

    const [movies,setMovies]=useState([]);
    const navigate=useNavigate();

    console.log(value);
    useEffect(()=>{
        axios.get(`https://api.sampleapis.com/movies/${value}`)
        .then((res)=>{setMovies(res.data)}).catch((e)=>{console.log(e);})
    },[value])// Update movies when the value prop changes


  return (
    <div>
        
        {movies.length > 0  ? <div className='movies row  '>
            {movies.map((movie)=>(
                <div className='movie card col-3' key={movie.id}>
                    <img src={movie.posterURL} alt={movie.title}   className='card-img card-img-top'/>
                    <h2 className='card-title'>{movie.title}</h2>
                    <button onClick={()=>navigate(`/movie/${movie.imdbId}`)}  className='card-footer'>See more</button> {/*we are doing dynamic routing */}
                 {/*  <button onClick={()=>navigate('./about')} />  using this we can navigate*/}
                </div>
            ))}
             </div> : <p>THERE IS NO MOVIES</p>}
    </div>
  )
}

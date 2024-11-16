import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';


export default function Movie() 
{

    const {id} = useParams(); {/* use params is used for read only we can read routing parameters */}
    
    const [movieData,setMovieData]=useState({})


    useEffect(() => {
        console.log(id); // Log parameters to the console
        
        axios.get(`https://www.omdbapi.com/?i=${id}&apikey=4827adaa`).then((res)=>{setMovieData(res.data)})
        {/* inside get we had given API with template whenever particular id is send as parameter will be given to that API template and give that particular data */}
    }, []);

    const handleRoute=()=>{
        window.location.href=`https://www.imdb.com/title/${id}`
    }

  return (
    <div>
        {movieData && (
            <div className='movieData row'>
                <div className='col-4'> 

                <img src={movieData.Poster} alt={movieData.Title} />

                </div>
            
            <div className='col-8'>

            <h2>{movieData.Title}</h2>
            <p>YEAR : {movieData.Year}</p>
            <p>Story : {movieData.Plot}</p>

            <button onClick={handleRoute}>IMDB link</button>
            </div>
                
            </div>
        )}
    </div>
  )
}

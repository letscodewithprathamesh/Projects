import React, { useRef, useState } from 'react'
import Header from './components/Header'
import Movies from './pages/Movies'
import Footer from './components/Footer'
import './App.css'
import {Route, Routes} from 'react-router-dom'
import Contact from './pages/Contact'
import About from './pages/About'
import Movie from './pages/Movie'
import 'bootstrap/dist/css/bootstrap.min.css'

export default function App() 
{


  const [selectmovie,setMovie]=useState("")

  const handleSelectChange=(e)=>{
    setMovie(e.target.value)
  }

  return (
    <div>
      <Header />

    <div className='options'>
      <select name="" id="" value={selectmovie} onChange={handleSelectChange} >
        <option >Select a Category</option>
        <option value="animation">ANIMATION</option>
        <option value="horror">HORROR</option>
        <option value="classic">CLASSIC</option>
        <option value="comedy">COMEDY</option>
      </select>
    </div>


      <Routes >
        <Route path='/' element={<Movies value={selectmovie} />}/>

        <Route path='/movie/:id' element={<Movie />}/> {/* Dynamic routing */}

        <Route path='/about' element={<About />} />

        <Route path='/contact' Component={Contact}/> {/* we use Component property instead of element where we don't need to write <Component /> tag instead just use Component */}

      </Routes>
      <Footer />
    </div>
  )
}

import React from 'react'
import { Route,Routes} from 'react-router-dom'
import Header from './components/Header'
import Footer from './components/Footer'
import Home from './Pages/Home'
import ProductList from './Pages/ProductList'
import ProductDetail from './Pages/ProductDetail'
import Cart from './Pages/Cart'
import NoPage from './Pages/NoPage'
import Login from './Pages/Login'
import SignUp from './Pages/SignUp'
import Dashboard from './Pages/Dashboard'

export default function App() {
  return (
    <>
    <Header />
    <Routes>
      <Route path='/' Component={Home}/>  

      <Route path='/Products' Component={ProductList} />

      <Route path='/Product/:id' Component={ProductDetail} />

      <Route path='/Cart' Component={Cart} />

      <Route
					path='/login'
					Component={Login}
				/>
				<Route
					path='/signup'
					Component={SignUp}
				/>
				<Route
					path='/dashboard'
					Component={Dashboard}
				/>

      <Route path='*' Component={NoPage} />


      </Routes>

    <Footer />
    </>
  
    

  )
}

import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { clearError, setError, setLoading } from '../Redux/store';
import { signInWithEmailAndPassword } from "firebase/auth";
import { auth } from '../firebase';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';

export default function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const error = useSelector((state) => state.product.error);

    async function handleLogin() {
        dispatch(clearError());
        try {
            signInWithEmailAndPassword(auth, email, password)
                .then(() => {
                    console.log("Login successful");
                    navigate('/dashboard');
                });
            dispatch(setLoading(false));
        } catch (error) {
            dispatch(setError(error.message));
        }
    }

    return (
        <div className="bg-gray-100 flex items-center justify-center h-screen">
            <div className="bg-white p-8 rounded-lg shadow-md flex flex-col items-center h-4/6 w-3/5 mb-6">
                <h1 className="text-3xl font-bold mb-4">Login Form</h1>
                <input
                    type="email"
                    id="email"
                    placeholder="Enter your email"
                    className='w-2/3 mb-4 bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out'
                    onChange={(e) => setEmail(e.target.value)}
                />
                <input
                    type="password"
                    id="password"
                    placeholder="Enter your password"
                    className='w-2/3 mb-4 bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out'
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button
                    onClick={handleLogin}
                    className="bg-blue-500 text-white font-bold py-2 px-4 rounded  mb-6focus:outline-none hover:bg-blue-600"
                >
                    LOGIN
                </button>
                <h2 className="mt-4">Not registered? <Link to="/signup" className="text-blue-500">Signup</Link></h2>
                {error && <p className="text-red-500 mt-4">{error}</p>}
            </div>
        </div>
    );
}

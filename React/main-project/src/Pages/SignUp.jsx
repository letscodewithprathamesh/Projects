import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { clearError, setError, setLoading } from '../Redux/store';
import { createUserWithEmailAndPassword } from "firebase/auth";
import { auth } from '../firebase';
import { useNavigate } from 'react-router-dom';

export default function SignUp() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [name, setName] = useState("");

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const error = useSelector((state) => state.product.error);

    async function handleSignUp() {
        dispatch(setLoading(true));
        dispatch(clearError());

        try {
            await createUserWithEmailAndPassword(auth, email, password);
            console.log("Signup successful");
            navigate('/login');
            dispatch(setLoading(false));
        } catch (error) {
            if (error.code === 'auth/email-already-in-use') {
                dispatch(setError("The email address is already in use."));
            } else {
                dispatch(setError(error.message));
            }
            dispatch(setLoading(false));
        }
    }

    return (
        <div className="flex items-center justify-center h-screen bg-lightyellow">
            <div className="bg-yellow-300 p-8 rounded-lg shadow-md flex flex-col items-center w-80">
                <h1 className="text-3xl font-bold mb-8">Signup</h1>
                <input
                    type="text"
                    id="name"
                    placeholder="Enter your Name"
                    className='w-full mb-4 bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out'
                    onChange={(e) => setName(e.target.value)}
                />
                <input
                    type="email"
                    id="email"
                    placeholder="Enter your Email"
                    className='w-full mb-4 bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out'
                    onChange={(e) => setEmail(e.target.value)}
                />
                <input
                    type="password"
                    id="password"
                    placeholder="Enter your Password"
                    className='w-full mb-4 bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out'
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button
                    onClick={handleSignUp}
                    className="bg-blue-500 text-white font-bold py-2 px-4 rounded focus:outline-none hover:bg-blue-600"
                >
                    Sign Up
                </button>
                {error && <p className="text-red-500 mt-4">{error}</p>}
            </div>
        </div>
    );
}

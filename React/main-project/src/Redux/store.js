import { configureStore, createSlice } from "@reduxjs/toolkit";


const initialState={
    products:[],
    cart:[],
    loading:false,
    error:null,
    user:null
}

const productSlicer=createSlice({
    name:"products",
    initialState,
    reducers:{
        setProducts(state,action)
        {
            state.products=action.payload
        },
        addCart(state,action)
        {
            state.cart.push(action.payload)
        },
        removeCart(state,action)
        {
            state.cart=state.cart.filter((item)=>item.id !=action.payload.id)
        },
        setUser(state,action)
        {
            state.user=action.payload
        },
        setLoading(state,action)
        {
            state.loading=action.payload
        },
        setError(state,action)
        {
            state.error=action.payload
        },
        clearError(state)
        {
            state.error=null;
        },
        signOut(state)
        {
            state.user=null;
        },

    }
})

export const {setProducts,addCart,removeCart,setError,setUser,setLoading,signOut,clearError}=productSlicer.actions

const store=configureStore({
    reducer:{
        product:productSlicer.reducer
    }
})

export default store;
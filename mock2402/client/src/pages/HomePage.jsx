import React from 'react'
import Header from '../components/Header'
import Menu from '../components/Menu'

const HomePage = () => {
    return (
        <div className='flex flex-col items-center w-screen h-screen bg-green-600'>

            <Header />
            <Menu />
        </div>
    )
}

export default HomePage
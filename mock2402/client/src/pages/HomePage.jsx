import React from 'react'
import Header from '../components/Header'
import Menu from '../components/Menu'
import Banner from '../components/Banner'
import HorizontalImageList from '../components/HorizontalImageList'
import CategoryList from '../components/CategoryList'

const HomePage = () => {
    return (
        <div className='flex flex-col w-screen h-auto'>

            <Header />
            <Menu />
            <Banner/>
            <HorizontalImageList/>
            <CategoryList/>

        </div>
    )
}

export default HomePage
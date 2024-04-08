import React from 'react'
import Header from '../components/Header'
import Menu from '../components/Menu'
import Banner from '../components/Banner'
import HorizontalImageList from '../components/HorizontalImageList'
import CategoryList from '../components/CategoryList'
import NewFeature from '../components/NewFeature'

const HomePage = () => {
    return (
        <div className='flex flex-col w-screen h-auto'>

            <Header />
            <Menu />
            <Banner/>
            <HorizontalImageList/>
            <CategoryList/>
            <NewFeature/>

        </div>
    )
}

export default HomePage
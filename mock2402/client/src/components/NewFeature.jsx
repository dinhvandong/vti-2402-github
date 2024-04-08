import React from 'react'
import ItemList from './ItemList'
import jsonData from './data.json'; // Assuming you have the JSON data in a separate file
const NewFeature = () => {
    return (
        <div className='  flex flex-col mt-[30px] justify-center items-center w-full h-auto '>
            <div className='flex flex-col justify-center w-4/5 h-auto'>

                <h1 className='font-bold'>Khám phá món mới</h1>
                <ItemList items={jsonData} />

            </div>
        </div>
    )
}

export default NewFeature
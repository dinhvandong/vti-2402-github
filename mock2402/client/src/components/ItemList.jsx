import React from 'react';
import { IoLocationOutline } from "react-icons/io5";
const ItemList = ({ items }) => {
    return (
        <div className="grid grid-cols-6 gap-4">
            {items.map((item, index) => (
                <div key={index} className="p-4 bg-white shadow">
                    <img src={item.image} alt={item.title} className="w-full h-auto mb-2" />
                    <p>{item.title}</p>
                    <p>{item.title}</p>

                    <div className='flex '>

                        <div className='px-2 font-bold text-white bg-orange-400 rounded-lg py-1/2'>
                            <p>QC</p>
                        </div>

                        <IoLocationOutline className='w-[25px] h-[25px]' />
                        <div>
                            <p>11.7km</p>
                        </div>

                    </div>
                    <button className='w-full py-1 mt-5 font-bold bg-gray-200 rounded-lg'>Chọn mua</button>


                </div>
            ))}
        </div>
    );
};

export default ItemList;
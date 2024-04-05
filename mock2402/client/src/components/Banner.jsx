import React from 'react'
import { IoSearch } from "react-icons/io5";
import { MdKeyboardArrowRight } from "react-icons/md";
import { MdLocationOn } from "react-icons/md";
const Banner = () => {

    const imageUrl = 'https://loship.vn/dist/images/home-banner-18062021.jpg'; // Replace with your image URL
    return (
        <div style={{ backgroundImage: `url(${imageUrl})` }} className='flex flex-col items-center justify-center w-full h-[280px] bg-cover'>
            <div className=' absolute mt-[80px] flex flex-col'>

            <div className='text-black  text-[50px] font-extrabold'>
                <p>ĐẶT MÓN NÀO</p>
            </div>
            <div className='text-red-600 font-extrabold text-[50px]'>
                <p>CŨNG FREESHIP</p>
            </div>
            <div className='flex flex-row w-[500px]'>

                <IoSearch className='w-[20px] h-[20px]' />
                <input className='w-full px-4 border-transparent focus:outline-none focus:ring-0' placeholder='Tìm quán ăn, trà sửa yêu thích để đặt Loship giao ngay' />
            </div>
            <div className='mt-[50px] flex flex-col w-[500px]'>
                <div><p>Giao tới địa chỉ</p></div>
                <div className='flex justify-between'>
                    <div className='flex'>

                        <MdLocationOn className='w-6 h-6 text-red-600'/>
                        <p className='font-bold'>
                            Hồ Chí Minh
                        </p>



                    </div>
                    <div>
                        <MdKeyboardArrowRight className='w-7 h-7' />
                    </div>

                </div>


            </div>

            </div>
           
        </div>
    )
}

export default Banner
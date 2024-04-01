import React from 'react'
import { IoMdArrowDropdown } from "react-icons/io";
import flagVN  from '../assets/flag_vietnam.png';
const Header = () => {
  return (
    <div className='flex items-center justify-center w-full h-[50px] '>

        <div className='flex items-center justify-center'>
            <img src={flagVN} className='w-[20px] h-[20px]'/>
            <p>
                Vietnamese
            </p>
            <IoMdArrowDropdown className='w-[25px] h-[25px]'/>
        </div>

    </div>
  )
}

export default Header
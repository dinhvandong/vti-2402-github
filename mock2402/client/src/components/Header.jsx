import React from 'react'
import { IoMdArrowDropdown } from "react-icons/io";
import flagVN from '../assets/flag_vietnam.png';
import { BsCart4 } from "react-icons/bs";

const Header = () => {
  return (
    <div className=' text-[12px] flex items-center justify-center w-full h-[50px] '>

      <div className='flex items-center justify-center'>
        <img src={flagVN} className='w-[20px] h-[20px]' />
        <p>
          Vietnamese
        </p>
        <IoMdArrowDropdown className='w-[25px] h-[25px]' />
      </div>

      <div className='ml-5'>
        <p>Tải ứng dụng Loship:</p>
      </div>
      <button className='px-2 ml-2 border-2 border-black rounded-lg hover:border-red-600 hover:text-red-600 py-1/2'>
        <p>iOS</p>
      </button>
      <button className='px-2 ml-2 border-2 border-black rounded-lg py-1/2'>
        <p>Android</p>
      </button>
      <div className='ml-2'>
        <p>
          - hoặc -
        </p>
      </div>
      <div className='flex items-center justify-center ml-2 hover:cursor-pointer'>
        <p>
          +84
        </p>
        <IoMdArrowDropdown className='w-[25px] h-[25px]' />
      </div>
      <div >
        <input className='border-2 border-black rounded-md' placeholder='Nhap so dien thoai' />
      </div>
      <div>
        <button className='ml-2 border-2 border-black rounded-md'>Gui link</button>
      </div>

      <div className='ml-5'>
        <button>
          Trở thành đối tác Loship

        </button>
      </div>
      <div className='ml-5'>
        <button>
          Đi chợ với Lomart
        </button>

      </div>
      <div className='ml-5'>
        <button>Loship Hỏi đáp</button>
      </div>

      <div className='flex ml-5'>

      <BsCart4 className='w-8 h-8 text-orange-700' />

      <div className='absolute flex text-[8px] items-center justify-center w-5 h-5 bg-green-500 rounded-full'>
        <p className='text-white'>10</p>

      </div>

      </div>


    </div>
  )
}

export default Header
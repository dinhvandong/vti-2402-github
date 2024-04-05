import React from 'react';

const MenuItem = ({ title, children }) => {
  return (
    <li className="relative">
      <button className="flex items-center justify-between w-full px-4 py-2 text-sm font-medium text-gray-900 bg-gray-100 rounded-md hover:bg-gray-200 focus:outline-none focus:bg-gray-200">
        {title}
        {children && (
          <svg
            className="w-4 h-4 ml-2 text-gray-500"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 20 20"
            fill="currentColor"
            aria-hidden="true"
          >
            <path
              fillRule="evenodd"
              d="M6 6a1 1 0 011-1h6a1 1 0 110 2H7a1 1 0 01-1-1zm0 4a1 1 0 011-1h6a1 1 0 110 2H7a1 1 0 01-1-1zm0 4a1 1 0 011-1h6a1 1 0 110 2H7a1 1 0 01-1-1z"
              clipRule="evenodd"
            />
          </svg>
        )}
      </button>
      {children && (
        <ul className="absolute w-40 py-1 mt-2 space-y-1 bg-white border border-gray-200 rounded-md shadow-lg left-full">
          {children}
        </ul>
      )}
    </li>
  );
};

export default MenuItem
import React from 'react'
import { Navigate } from 'react-router-dom'

function ProtectedRoute({ isAuthorized, children }) {

  return (
    <div>
        {isAuthorized? children: <Navigate to="/login" replace />}
    </div>
  )
}

export default ProtectedRoute
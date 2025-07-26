import React, { createContext, useContext, useState, useEffect } from 'react'

const AuthContext = createContext()

export const useAuth = () => {
  const context = useContext(AuthContext)
  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider')
  }
  return context
}

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null)
  const [loading, setLoading] = useState(true)

useEffect(() => {
  try {
    const storedUser = localStorage.getItem('user')
    if (storedUser) {
      setUser(JSON.parse(storedUser)) // ✅ now safely parsed
    }
  } catch (error) {
    console.error('Failed to parse user from localStorage:', error)
    localStorage.removeItem('user') // 🧹 clean up invalid entry
  } finally {
    setLoading(false)
  }
}, [])


  const login = async (email, password) => {
    // Simulate API call
    await new Promise(resolve => setTimeout(resolve, 1000))
    
    const userData = {
      id: '1',
      name: 'John Farmer',
      email,
      type: 'farmer',
      farmLocation: 'Tamil Nadu, India',
      joinDate: '2024-01-15'
    }
    
    setUser(userData)
    localStorage.setItem('user', JSON.stringify(userData))
    return userData
  }

  const register = async (userData) => {
    // Simulate API call
    await new Promise(resolve => setTimeout(resolve, 1000))
    
    const newUser = {
      id: Date.now().toString(),
      ...userData,
      type: 'farmer',
      joinDate: new Date().toISOString().split('T')[0]
    }
    
    setUser(newUser)
    localStorage.setItem('user', JSON.stringify(newUser))
    return newUser
  }

  const logout = () => {
    setUser(null)
    localStorage.removeItem('user')
  }

  const value = {
    user,
    loading,
    login,
    register,
    logout
  }

  return (
    <AuthContext.Provider value={value}>
      {children}
    </AuthContext.Provider>
  )
}
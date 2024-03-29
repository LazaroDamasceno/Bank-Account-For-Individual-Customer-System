import { BrowserRouter, Route, Routes } from "react-router-dom"
import { RegisterCustomer } from "./RegisterCustomer"
import { DeleteAllCustomers } from "./DeleteAllCustomers"
import { Home } from "./Home"

export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/register-customer" element={<RegisterCustomer />}></Route>
                <Route path="/delete-all-customers" element={<DeleteAllCustomers />}></Route>
            </Routes>
        </BrowserRouter>
    )
}
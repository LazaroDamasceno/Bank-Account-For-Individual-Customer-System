import { BrowserRouter, Route, Routes } from "react-router-dom"
import { RegisterCustomer } from "./RegisterCustomer"
import { DeleteAllCustomers } from "./DeleteAllCustomers"
import { Home } from "./Home"
import { UpdateCustomer } from "./UpdateCustomer"
import { DeleteCustomerBySsn } from "./DeleteCustomerBySsn"

export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/register-customer" element={<RegisterCustomer />} />
                <Route path="/delete-all-customers" element={<DeleteAllCustomers />} />
                <Route path="/update-customer" element={<UpdateCustomer />} />
                <Route path="/delete-customer-by-ssn" element={<DeleteCustomerBySsn />} />
            </Routes>
        </BrowserRouter>
    )
}
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { RegisterCustomer } from "./RegisterCustomer";
import { DeleteAllCustomers } from "./DeleteAllCustomers";
import { Home } from "./Home";
import { UpdateCustomer } from "./UpdateCustomer";
import { CreateBankAccount } from "./CreateBankAccount";
import { FindAllCustomers } from "./FindAllCustomers";
import { FindAllBankAccounts } from "./FindAllBankAccounts";

const routes = [
  { path: "/", element: <Home /> },
  { path: "/register-customer", element: <RegisterCustomer /> },
  { path: "/delete-all-customers", element: <DeleteAllCustomers /> },
  { path: "/update-customer", element: <UpdateCustomer /> },
  { path: "/create-bank-account", element: <CreateBankAccount /> },
  { path: "/find-all-customers", element: <FindAllCustomers /> },
  { path: "/find-all-bank-accounts", element: <FindAllBankAccounts /> }
];

export const AppRouter = () => (
  <BrowserRouter>
    <Routes>
      {routes.map(({ path, element }) => (
        <Route key={path} path={path} element={element} />
      ))}
    </Routes>
  </BrowserRouter>
);

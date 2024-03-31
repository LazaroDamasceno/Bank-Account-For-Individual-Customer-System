import { BrowserRouter, Route, Routes } from "react-router-dom";
import { RegisterCustomer } from "../components/RegisterCustomer";
import { DeleteAllCustomers } from "../components/DeleteAllCustomers";
import { Home } from "../components/Home";
import { UpdateCustomer } from "../components/UpdateCustomer";
import { CreateBankAccount } from "../components/CreateBankAccount";
import { FindAllCustomers } from "../components/FindAllCustomers";
import { FindAllBankAccounts } from "../components/FindAllBankAccounts";
import { DepositCash } from "../components/DepositCash";

const routes = [
  { path: "/", element: <Home /> },
  { path: "/register-customer", element: <RegisterCustomer /> },
  { path: "/delete-all-customers", element: <DeleteAllCustomers /> },
  { path: "/update-customer", element: <UpdateCustomer /> },
  { path: "/create-bank-account", element: <CreateBankAccount /> },
  { path: "/find-all-customers", element: <FindAllCustomers /> },
  { path: "/find-all-bank-accounts", element: <FindAllBankAccounts /> },
  { path: "/deposit-cash", element: <DepositCash /> }
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

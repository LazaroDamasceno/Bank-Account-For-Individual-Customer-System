import axios from "axios"

export const DeleteAllCustomers = () => {

    async function deleteAll() {
        await axios.delete("http://localhost:8080/api/v1/customers")
    }

    return (
        <>
            <head>
                <title>Delete all customers</title>
            </head>
            <body>
                <form onSubmit={deleteAll}>
                    <input className="btn btn-warning" type="submit" value="Delete all customers" />
                </form>   
            </body>
        </>
    )

}
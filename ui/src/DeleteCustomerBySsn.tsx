import axios from "axios"
import { useState } from "react"

export const DeleteCustomerBySsn = () => {

    const [ssn, setSsn] = useState({
        ssn: ''
    })

    async function deleteBySsn() {
        await axios.delete(`http://localhost:8080/api/v1/customer/${ssn.ssn}`)
    }

    const handleChange = (event: any) => {
        setSsn({...ssn, [event.target.name]:event.target.value})
    }


    return (
        <>
            <head>
                <title>Delete customer by ssn</title>
            </head>
            <body>
                <form onSubmit={deleteBySsn}>
                    <div>
                        <label>SSN: </label>
                        <input 
                            onChange={handleChange}
                            value={ssn.ssn}
                            type="text"
                            name="ssn"
                        />
                    </div>
                    <br/><br/>
                    <input className="btn btn-warning" type="submit" value="Delete by ssn"></input>
                </form>
            </body>
        </>
    )

}
<html>
    <body>
        <h1>BonaFide Plus Assignment Submission</h1>
        <form action="rest/getdata" method="post">
            <p>
               Student Name : <input type="text" name="stname" />
            </p>
            <p>
               Student Number : <input type="text" name="stnum" />
            </p>            
            <p>
               User Token : <input type="text" name="usertoken" />
            </p>            
            <p>
            <input type="radio" name="Provider" value="SKT" checked>SKT
			<input type="radio" name="Provider" value="KT">KT
			<input type="radio" name="Provider" value="LGT">LGT
            </p>            
            <p>
               Data Plan : <input type="text" name="dataplan" />
            </p>
            <p>
            <input type="radio" name="Network" value="3G" checked>3G
			<input type="radio" name="Network" value="LTE">LTE
			<input type="radio" name="Network" value="LTE-A">LTE-A
			<input type="radio" name="Network" value="3 Band LTE">3 Band LTE
            </p>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
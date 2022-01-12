# COVID-19 Info Extraction API
Hosts a TomEE container (Jakarta 9) that retrieves the mostly likely locations New Yorkers would attend during the pandemic.

## Installation
    1. Clone master
    2. If you're using Intellij/Eclipse, you should have your dependencies installed,
    3. **Not recommended:**  create a new Java enterprise application with Javakarta 9
    4. Run the app and you'll find the host info on the console log
    5. The API host info should be listed on the console, use a REST Client (Postman, ARC extension on Chrome, etc.) to retrieve filtered data
    6. Please refer to the code of the file to get more info about each component of the MVC layer

## Run
    1. Enter a valid age range
    2. For info on correct attributes, please check MIT's site
    3. The API should return a filtered out response to your request

## Citations
#### Thanks to help from MIT COVID-19 survey and their public APIs
<a id="1">[1]</a>
Collis, A., Garimella, K., Moehring, A., Rahimian, M.A., Babalola, S., Gobat, N., Shattuck, D.,  Stolow, J., Eckles, D., and Aral, S. (2020). Global survey on COVID-19 beliefs, behaviors, and norms. Technical report, MIT Sloan School of Management

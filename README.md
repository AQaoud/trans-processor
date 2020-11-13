# trans-processor
Java library for transactions via different input types. Processing contains converting from input types to Transaction DTO object and validating the object values.

## Important Notes

- gRPC beans are mocked by plain POJOs.
- Input beans looks similar, but they are different and there was no way to merge them in the same classes 
without adding some coupling between different input types. I even tried to merge XML and JSON input
beans but couldn't due to parsing library (Jaxb) restrictions. 
- There are no added validations on input beans as validations are covered by "trans-core" module which contains
 Transaction DTO.

## Cloning

Git cloning command may be used to clone the library source code as follows:

```bash
git clone https://github.com/AQaoud/trans-processor.git
```

## Test cases

Test cases could be run by IDE or through gradle command on project root folder:
```bash
gradle test
```

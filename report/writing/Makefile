
build:
	npx mmdc -i ../class-diagrams/uml-tourism.mmd -o uml-build-output.svg -s 4
	pandoc report.md -t latex -o report.pdf --from markdown --template eisvogel --toc --listings --citeproc --bibliography=references.bib
clean: 
	rm report.pdf
	rm uml-build-output.svg

import crypto from "crypto";

const raw = `Manufacturing
@Construction materials
@Electronics and Optics
@Food and Beverage
@@Bakery & confectionery products
@@Beverages
@@Fish & fish products 
@@Meat & meat products
@@Milk & dairy products 
@@Other
@@Sweets & snack food
@Furniture
@@Bathroom/sauna 
@@Bedroom
@@Children’s room 
@@Kitchen 
@@Living room 
@@Office
@@Other (Furniture)
@@Outdoor 
@@Project furniture
@Machinery
@@Machinery components
@@Machinery equipment/tools
@@Manufacture of machinery 
@@Maritime
@@@Aluminium and steel workboats 
@@@Boat/Yacht building
@@@Ship repair and conversion
@@Metal structures
@@Other
@@Repair and maintenance service
@Metalworking
@@Construction of metal structures
@@Houses and buildings
@@Metal products
@@Metal works
@@@CNC-machining
@@@Forgings, Fasteners 
@@@Gas, Plasma, Laser cutting
@@@MIG, TIG, Aluminum welding
@Plastic and Rubber
@@Packaging
@@Plastic goods
@@Plastic processing technology
@@@Blowing
@@@Moulding
@@@Plastics welding and processing
@@Plastic profiles
@Printing 
@@Advertising
@@Book/Periodicals printing
@@Labelling and packaging printing
@Textile and Clothing
@@Clothing
@@Textile
@Wood
@@Other (Wood)
@@Wooden building materials
@@Wooden houses
Other
@Creative industries
@Energy technology
@Environment
Service
@Business services
@Engineering
@Information Technology and Telecommunications
@@Data processing, Web portals, E-marketing
@@Programming, Consultancy
@@Software, Hardware
@@Telecommunications
@Tourism
@Translation services
@Transport and Logistics
@@Air
@@Rail
@@Road
@@Water`;

function createRow(name, id, parent) {
    return `INSERT INTO sector VALUES (${name}, ${id}, ${parent});\n`;
}

function countLevels(string) {
    return (string.match(new RegExp("@", "g")) || []).length;
}

const split = raw.split("\n");

let sectors = [];
for (let i = 0; i < split.length; i++) {
    const element = split[i];
    const level = countLevels(element);

    const name = element.replaceAll("@", "");

    if (level === 0) {
        sectors.push([name]);
    }

    if (level === 1) {
        sectors.at(-1).push([name]);
    }

    if (level === 2) {
        sectors.at(-1).at(-1).push([name]);
    }

    if (level === 3) {
        sectors.at(-1).at(-1).at(-1).push([name]);
    }
}


let generated = [];
function generate(sectors, parentId) {
    const id = `'${crypto.randomUUID()}'`;
    const name = `'${sectors.at(0)}'`;
    const parent = parentId ? parentId : "NULL";

    const row = createRow(name, id, parent);
    generated.push(row);

    for (let i = 1; i < sectors.length; i++) {
        const element = sectors[i];
        generate(element, id);
    }
}

sectors.forEach(s => generate(s))
console.log(generated.join(""));

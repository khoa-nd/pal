function Advisor (obj) {
    BaseEntity.call(this, {
        email: "",
        display_name: "",
        first_name: "",
        last_name: "",
        exp: 0,
        city: "",
        address: "",
        school: ""
    }, obj);
}
Advisor.prototype = Object.create(BaseEntity.prototype);
Advisor.prototype.constructor = Advisor;

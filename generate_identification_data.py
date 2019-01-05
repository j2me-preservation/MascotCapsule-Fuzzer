import random

def randvector(min, max):
    return random.randrange(min, max), random.randrange(min, max), random.randrange(min, max)

def generate_int(name, count, min, max):
    for i in range(count):
        print(name, random.randrange(min, max))

def generate_vector(name, count, min, max):
    for i in range(count):
        print(name, *randvector(min, max))

def generate_2vector(name, count, min, max):
    for i in range(count):
        print(name, *randvector(min, max), *randvector(min, max))

# TODO: should focus on testing *interesting* values
#       such as 1023, 1024, 2047, 2048, -1023, -1024 etc.
#       (to understand rounding rules)
generate_int('Util3D.cos',               20, -2**31, 2**31-1)
generate_int('Util3D.sin',               20, -2**31, 2**31-1)

generate_int('Util3D.sqrt',              20, -2**31, 2**31-1)
generate_vector('Vector3D.unit',            20, -32768, 32767)
generate_2vector('Vector3D.innerProduct',   20, -32768, 32767)
generate_2vector('Vector3D.outerProduct',   20, -32768, 32767)

# TODO: ActionTable.getNumActions
# TODO: ActionTable.getNumFrames

# TODO: AffineTrans.lookAt
# TODO: AffineTrans.mul
# TODO: AffineTrans.rotationV
# TODO: AffineTrans.rotationX
# TODO: AffineTrans.rotationY
# TODO: AffineTrans.rotationZ
# TODO: AffineTrans.transform

# TODO: Figure.getNumPattern
# TODO: Figure.getNumTextures
